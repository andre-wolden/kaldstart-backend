package com.funkoa.Kaldstart

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import sh.ory.kratos.ApiClient
import sh.ory.kratos.ApiException
import sh.ory.kratos.Configuration
import sh.ory.kratos.api.MetadataApi
import sh.ory.kratos.model.InlineResponse2001

@SpringBootApplication
class KaldstartApplication

fun main(args: Array<String>) {

	val defaultClient: ApiClient = Configuration.getDefaultApiClient()
	defaultClient.setBasePath("http://localhost:4433")

	val apiInstance: MetadataApi = MetadataApi(defaultClient)
	try {
		val version: InlineResponse2001 = apiInstance.getVersion()
		println("Ory api version")
		println(version)
	} catch (e: ApiException) {
		println("Exception when calling MetadataApi#getVersion")
		println("Status code: " + e.getCode())
		println("Reason: " + e.getResponseBody())
		println("Response headers: " + e.getResponseHeaders())
		e.printStackTrace()
	}

	runApplication<KaldstartApplication>(*args)
}
