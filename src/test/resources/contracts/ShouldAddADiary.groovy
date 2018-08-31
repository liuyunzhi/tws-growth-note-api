import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_add_a_diary"
    request {
        method POST()
        url("/diaries")
        headers {
            contentType(applicationJson())
        }
        body(file("request.json"))
    }
    response {
        status(201)
    }
}