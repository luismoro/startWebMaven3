package br.com.config;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class CorsFilter implements Filter {

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse response = (HttpServletResponse) res;

		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods", "POST, PATCH, PUT, GET, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age", "0");
		response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type, X-DEVICE-FINGERPRINT");
		response.addHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
		response.addHeader("Edge-Control", "no-cache, no-store, max-age=0, must-revalidate");
		response.addHeader("Pragma", "no-cache");
		response.addIntHeader("Expires", 0);
		response.addHeader("etag", UUID.randomUUID().toString());
		chain.doFilter(req, res);

	}

	public void init(FilterConfig filterConfig) {}

	public void destroy() {}

}
