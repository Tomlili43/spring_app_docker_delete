package com.aift.lukie.utilities;


import java.io.IOException;
import java.util.Base64;
import javax.crypto.spec.SecretKeySpec;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class SecretKeySpecDeserializer extends JsonDeserializer<SecretKeySpec> {
    @Override
    public SecretKeySpec deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        String encoded = node.get("encoded").asText();
        String algorithm = node.get("algorithm").asText();
        byte[] keyBytes = Base64.getDecoder().decode(encoded);
        return new SecretKeySpec(keyBytes, algorithm);
    }
}
