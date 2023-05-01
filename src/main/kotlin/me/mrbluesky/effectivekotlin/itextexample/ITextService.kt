package me.mrbluesky.effectivekotlin.itextexample

import com.itextpdf.kernel.geom.Rectangle
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfReader
import com.itextpdf.kernel.pdf.canvas.parser.EventType
import com.itextpdf.kernel.pdf.canvas.parser.PdfCanvasProcessor
import com.itextpdf.kernel.pdf.canvas.parser.data.IEventData
import com.itextpdf.kernel.pdf.canvas.parser.data.TextRenderInfo
import com.itextpdf.kernel.pdf.canvas.parser.filter.TextRegionEventFilter
import com.itextpdf.kernel.pdf.canvas.parser.listener.FilteredEventListener
import com.itextpdf.kernel.pdf.canvas.parser.listener.LocationTextExtractionStrategy
import org.springframework.stereotype.Service
import java.io.BufferedWriter
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStreamWriter


@Service
class ITextService {

    @Throws(IOException::class)
    fun manipulatePdf(source: String?): String {
        val pdfDoc = PdfDocument(PdfReader(source))
        val rect = Rectangle(36F, 750F, 523F, 56F)
//        val fontFilter = CustomFontFilter(rect)
        val listener = FilteredEventListener()

        // Create a text extraction renderer
        val extractionStrategy = LocationTextExtractionStrategy();

        // Note: If you want to re-use the PdfCanvasProcessor, you must call PdfCanvasProcessor.reset()
        val parser = PdfCanvasProcessor(extractionStrategy)
        parser.processPageContent(pdfDoc.firstPage)

        // Get the resultant text after applying the custom filter
        val actualText = extractionStrategy.resultantText
        pdfDoc.close()

        // See the resultant text in the console
        println("text: $actualText")
        return actualText
    }

    @Throws(IOException::class)
    fun manipulatePdftoHtml(source: String?): String {
        val pdfDoc = PdfDocument(PdfReader(source))
        val rect = Rectangle(36F, 750F, 523F, 56F)
//        val fontFilter = CustomFontFilter(rect)
        val listener = FilteredEventListener()

        // Create a text extraction renderer
        val extractionStrategy = LocationTextExtractionStrategy();

        // Note: If you want to re-use the PdfCanvasProcessor, you must call PdfCanvasProcessor.reset()
        val parser = PdfCanvasProcessor(extractionStrategy)
        parser.processPageContent(pdfDoc.firstPage)

        // Get the resultant text after applying the custom filter
        val actualText = extractionStrategy.resultantText
        pdfDoc.close()

        // See the resultant text in the console
        println("text: $actualText")
        return actualText
    }


}