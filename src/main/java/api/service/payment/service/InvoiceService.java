package api.service.payment.service;

import api.service.payment.entity.Invoice;
import api.service.payment.repository.InvoiceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Long id) {
        return invoiceRepository.findById(Math.toIntExact(id)).orElse(null);
    }

    public Invoice updateInvoice(Long id, Invoice invoiceDetails) {
        Invoice invoice = invoiceRepository.findById(Math.toIntExact(id)).orElse(null);
        if (invoice != null) {
            invoice.setTotalAmount(invoiceDetails.getTotalAmount());
            invoice.setIssueDate(invoiceDetails.getIssueDate());
            invoice.setDueDate(invoiceDetails.getDueDate());
            invoice.setStatus(invoiceDetails.getStatus());
            return invoiceRepository.save(invoice);
        }
        return null;
    }

    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(Math.toIntExact(id));
    }
}
