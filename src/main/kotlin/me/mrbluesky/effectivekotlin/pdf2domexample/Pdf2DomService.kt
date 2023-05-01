//package me.mrbluesky.effectivekotlin.pdf2domexample
//
//import org.apache.pdfbox.pdmodel.PDDocument
////import org.fit.pdfdom.PDFDomTree
//import org.springframework.stereotype.Service
//import org.w3c.dom.Document
//import java.io.File
//
//
//@Service
//class Pdf2DomService {
//
//    fun getDomFromHtml(src: String): String {
//        val file = File(src)
//        val pdf: PDDocument = PDDocument.load(file)
////        val parser = PDFDomTree()
//        val dom: Document = parser.createDOM(pdf)
//        println(dom.documentElement.textContent)
//        return dom.documentElement.textContent
//    }
//
//}