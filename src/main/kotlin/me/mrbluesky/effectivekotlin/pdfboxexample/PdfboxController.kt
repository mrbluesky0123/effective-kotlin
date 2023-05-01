package me.mrbluesky.effectivekotlin.pdfboxexample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pdf2dom")
class PdfboxController(val pdf2DomService: PdfboxService) {

    @GetMapping("/text")
    fun getDomFromPdf(): String {
        return pdf2DomService.getDomFromHtml("/Users/mrbluesky/Downloads/120230428013323963.pdf")
    }

}