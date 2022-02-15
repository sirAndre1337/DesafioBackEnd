package com.desafio.components;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.desafio.entities.Client;
import com.desafio.repositories.ClientReposity;

@Component
public class JwtTokenEnhancer implements TokenEnhancer {

	@Autowired
	private ClientReposity clientRepository;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

		Client client = clientRepository.findByLogin(authentication.getName());

		Map<String, Object> map = new HashMap<>();
		map.put("clientName", client.getName());
		map.put("clientId", client.getId());

		DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) accessToken;
		token.setAdditionalInformation(map);

		return accessToken;
	}

}
