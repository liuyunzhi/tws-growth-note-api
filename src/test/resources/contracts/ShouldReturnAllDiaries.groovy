import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_return_all_diaries"
    request {
        method GET()
        url("/diaries") {
            queryParameters {
                parameter("page", "0")
                parameter("pageSize", "10")
            }
        }
    }
    response {
        status OK()
        body(file("response.json"))
        headers {
            contentType(applicationJson())
        }
    }
}