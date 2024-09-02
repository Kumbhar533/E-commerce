package com.ms.ecommerce.notification.email;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import com.ms.ecommerce.notification.product.Product;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

	private final JavaMailSender javaMailSender;

	private final SpringTemplateEngine templateEngine;

	public void sendPaymentSucessfulEmail(String destinationEmail, String customerName, BigDecimal amount,
			String orderReference) throws MessagingException {

		MimeMessage mime = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mime, MimeMessageHelper.MULTIPART_MODE_RELATED,
				StandardCharsets.UTF_8.name());

		helper.setFrom("nileshkumbhar533@gmail.com");
		final String template = EmailTemplate.PAYMENT_CONFIRMATION.getTemplate();

		Map<String, Object> variables = new HashMap<String, Object>();

		variables.put("customerName", customerName);
		variables.put("amount", amount);
		variables.put("orderReference", orderReference);

		Context context = new Context();
		context.setVariables(variables);
		helper.setSubject(EmailTemplate.PAYMENT_CONFIRMATION.getSubject());

		try {
			String htmlTemplate = templateEngine.process(template, context);

			helper.setText(htmlTemplate, true);
			helper.setTo(destinationEmail);
			log.info("email successfully sent to {}", destinationEmail);

		} catch (MessagingException e) {
			log.warn("Email can not send to this Address :-> {}", destinationEmail);
		}

	}

	public void sendOrderConfirmationEmail(String destinationEmail, String customerName, BigDecimal amount,
			String orderReference, List<Product> products) throws MessagingException {

		MimeMessage mime = javaMailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(mime, MimeMessageHelper.MULTIPART_MODE_RELATED,
				StandardCharsets.UTF_8.name());

		helper.setFrom("nileshkumbhar533@gmail.com");
		final String template = EmailTemplate.ORDER_CONFIRMATION.getTemplate();

		Map<String, Object> variables = new HashMap<String, Object>();

		variables.put("customerName", customerName);
		variables.put("totalAmount", amount);
		variables.put("orderReference", orderReference);
		variables.put("products", products);

		Context context = new Context();
		context.setVariables(variables);
		helper.setSubject(EmailTemplate.ORDER_CONFIRMATION.getSubject());

		try {
			String htmlTemplate = templateEngine.process(template, context);

			helper.setText(htmlTemplate, true);
			helper.setTo(destinationEmail);
			log.info("email successfully sent to {}", destinationEmail);

		} catch (MessagingException e) {
			log.warn("Email can not send to this Address :-> {}", destinationEmail);
		}

	}

}
