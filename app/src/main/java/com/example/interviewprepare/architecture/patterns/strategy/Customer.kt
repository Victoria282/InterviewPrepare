package com.example.interviewprepare.architecture.patterns.strategy

data class Customer(val name: String, val membershipType: MembershipType)

enum class MembershipType {
    REGULAR, PREMIUM
}