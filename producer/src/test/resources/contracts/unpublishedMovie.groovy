import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath $(regex('/movies/22/status'))
    }
    response {
        status 404
        body("""{"published":false}""")
        headers {
            contentType(applicationJson())
        }
    }
}
