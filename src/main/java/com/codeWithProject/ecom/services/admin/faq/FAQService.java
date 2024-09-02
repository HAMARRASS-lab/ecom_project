package com.codeWithProject.ecom.services.admin.faq;

import com.codeWithProject.ecom.dto.FAQDto;

public interface FAQService {

    public FAQDto postFAQ(Long productId, FAQDto faqDto);
}
