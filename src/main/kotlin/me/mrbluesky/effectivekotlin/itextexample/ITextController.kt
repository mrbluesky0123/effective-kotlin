package me.mrbluesky.effectivekotlin.itextexample

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/itext")
class ITextController(val iTextService: ITextService) {

    @GetMapping("/text")
    fun getTextFromPdf(): String {
        return iTextService.manipulatePdf("/Users/mrbluesky/Downloads/120230428013323963.pdf")
    }

}