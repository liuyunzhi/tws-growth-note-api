import org.springframework.cloud.contract.spec.Contract

Contract.make {
    name "should_delete_a_diary_given_diary_id"
    request {
        method DELETE()
        url("/diaries/3")
    }
    response {
        status NO_CONTENT()
    }
}