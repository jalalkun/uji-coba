package com.example.ujicoba

import com.auth0.android.jwt.JWT


fun main() {
//    val token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwczovL2Fjdi1zdmMtYWNjb3VudC1xYS5hY3YuYXN0cmEuY28uaWQvYWN2L2F1dGgvbG9naW4iLCJpYXQiOjE2NDcyNDQ4MzUsImV4cCI6MTY0Nzg0OTYzNSwibmJmIjoxNjQ3MjQ0ODM1LCJqdGkiOiJxQkhTUXN5TlpaenhjNGtzIiwic3ViIjoxMzksInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.Hetwf9pMSURY1E8yOofp5tC48iVy4mum5mD0RcjXyns"
    val token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiYWRtaW4iOnRydWV9.TJVA95OrM7E2cBab30RMHrHDcEfxjoYZgeFONFh7HgQ"
    val jwt = JWT(token)
    println("token expired ${jwt.expiresAt}")
}