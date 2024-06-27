package net.guneyilmaz0.riotapi.enums

enum class ResponseCode(val code: Int, val message: String) {
    BAD_REQUEST(400, "Bad request"),
    UNAUTHORIZED(401, "Unauthorized"),
    FORBIDDEN(403, "Forbidden"),
    DATA_NOT_FOUND(404, "Data not found"),
    METHOD_NOT_ALLOWED(405, "Method not allowed"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported media type"),
    RATE_LIMIT_EXCEEDED(429, "Rate limit exceeded"),
    INTERNAL_SERVER_ERROR(500, "Internal server error"),
    BAD_GATEWAY(502, "Bad gateway"),
    SERVICE_UNAVAILABLE(503, "Service unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway timeout"),
    NOT_DEFINED_ERROR_CODE(0, "Not defined error code.");

    companion object {
        fun fromCode(code: Int): ResponseCode = entries.find { it.code == code } ?: NOT_DEFINED_ERROR_CODE
    }
}