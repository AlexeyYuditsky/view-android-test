package com.alexeyyuditsky.test.example

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.future.future
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

data class Item(
    val id: Int,
    val text: String
)

data class Post(
    val id: Int,
    val text: String
)

suspend fun main() {
    val item = Item(1, "lala")

    postItem1(item)
    postItem2(item)
}

fun processPost(post: Post) = println(post)

fun postItem1(item: Item) {
    val token = requestToken()
    val post = createPost(token, item)
    processPost(post)
}

fun postItem2(item: Item) {
    requestTokenAsync { token: String ->
        createPostAsync(token, item) { post ->
            processPost(post)
        }
    }
}

fun createPostAsync(token: String, item: Item, cb: (Post) -> Unit) {
    val post = createPost(token, item)
    cb.invoke(post)
}

fun createPost(token: String, item: Item): Post {
    Thread.sleep(500)
    return Post(1, "MyText")
}

fun requestTokenAsync(cb: (String) -> Unit) {
    val result = requestToken()
    cb.invoke(result)
}

fun requestToken(): String {
    Thread.sleep(500)
    return "myToken"
}