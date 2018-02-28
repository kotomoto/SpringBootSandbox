package org.koto.restplayground

import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class RestPlaygroundApplicationTests {

//    val logger = LoggerFactory.getLogger(RestPlaygroundApplicationTests::class.java)

    @Test
    fun contextLoads() {
    }

    @Test
    fun simpleGet() {
        val tester = Single.create<Boolean> { emitter ->
            val response = performSingleGetRequest()
            if (response.isSuccessful) {
                emitter.onSuccess(true)
            } else {
				emitter.onError(IllegalStateException("Http error with ${response.code()}"))
            }
        }.test()

        tester.awaitTerminalEvent()

        tester.assertNoErrors()
    }

    fun performSingleGetRequest(): Response {
        val request = Request.Builder()
                .url("https://mvnrepository.com/artifact/org.slf4j/slf4j-simple/1.7.25")
                .get()
                .build()

        val client = OkHttpClient.Builder().build()

        return client.newCall(request).execute()
    }
}
