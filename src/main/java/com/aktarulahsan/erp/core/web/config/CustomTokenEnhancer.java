package com.aktarulahsan.erp.core.web.config;

import com.aktarulahsan.erp.core.persistence.domain.entity.Users;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.LinkedHashMap;
import java.util.Map;

public class CustomTokenEnhancer extends JwtAccessTokenConverter {
	
	
	/**
	 * Enhace access token. This will send as response.
	 * @author Mindbowser | md.aktarulahsan@gmail.com
     * @since Apr 28, 2020
	 */
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Users users = (Users) authentication.getPrincipal();
		Map<String, Object> info = new LinkedHashMap<>(accessToken.getAdditionalInformation());
		info.put("email", users.getEmail());
		DefaultOAuth2AccessToken customAccessToken = new DefaultOAuth2AccessToken(accessToken);
		customAccessToken.setAdditionalInformation(info);
		return super.enhance(customAccessToken, authentication);
	}
}