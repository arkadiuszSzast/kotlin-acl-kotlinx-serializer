package com.szastarek.acl

import com.szastarek.acl.authority.Authority
import com.szastarek.acl.utils.customAuthorities
import com.szastarek.acl.utils.injectedAuthorities
import com.szastarek.acl.utils.regularAccountAuthorities
import io.kotest.core.spec.style.DescribeSpec
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class SerializersTest : DescribeSpec({

    describe("Serializers") {

        describe("Authority") {

            it("should serialize and deserialize") {
                val json = Json

                //regularAccountAuthorities
                val encodedRegularAccountAuthorities = json.encodeToString(regularAccountAuthorities)
                val decodedRegularAccountAuthorities = json.decodeFromString<List<Authority>>(encodedRegularAccountAuthorities)

                expectThat(decodedRegularAccountAuthorities).isEqualTo(regularAccountAuthorities)

                //customAuthorities
                val encodedCustomAuthorities = json.encodeToString(customAuthorities)
                val decodedCustomAuthorities = json.decodeFromString<List<Authority>>(encodedCustomAuthorities)

                expectThat(decodedCustomAuthorities).isEqualTo(customAuthorities)

                //injected authorities
                val encodedInjectedAuthorities = json.encodeToString(injectedAuthorities)
                val decodedInjectedAuthorities = json.decodeFromString<List<Authority>>(encodedInjectedAuthorities)

                expectThat(decodedInjectedAuthorities).isEqualTo(injectedAuthorities)
            }

        }

    }
})