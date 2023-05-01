package me.mrbluesky.effectivekotlin.pdfboxexample

import org.apache.pdfbox.pdmodel.PDDocument
import org.fit.pdfdom.PDFDomTree
import org.springframework.stereotype.Service
import org.w3c.dom.Document
import java.io.File


@Service
class PdfboxService {

    fun getDomFromHtml(src: String): String {
        val pdf = PDDocument.load(File(src))
//        println("## pdf: ${ pdf.document.print()}")
        val parser = PDFDomTree()
        val dom: Document = parser.createDOM(pdf)
//        val output: Writer = PrintWriter("pdf.html", "utf-8")
//        PDFDomTree().writeText(pdf, output)
//        pdf.document.print()
// documentElement.textContent
        println("## text: ${dom.documentElement.textContent}")
//        output.close()
        return "success"
    }

}