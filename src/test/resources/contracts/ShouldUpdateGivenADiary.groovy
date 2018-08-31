import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_update_given_a_diary"
    request {
        method PUT()
        headers {
            contentType(applicationJson())
        }
        body(file("request.json"))
        url("/diaries/1")
    }
    response {
        status NO_CONTENT()
    }
}