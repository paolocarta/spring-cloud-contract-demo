import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath $(regex('/movies/10/status'))
    }
    response {
        status 200
        body("""{"published":true}""")
        headers {
            contentType(applicationJson())
        }
    }
}
