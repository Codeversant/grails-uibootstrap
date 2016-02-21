package grails.uibootstrap

class StdTableTagLib {
    static namespace = "boots"
    static defaultEncodeAs = [taglib: 'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static LF = "\n"

    def getProperty(object, String property) {

        property.tokenize('.').inject object, {obj, prop ->
            obj[prop]
        }
    }

    def stdTable = { Map attrsMap, body ->
        //out << "<script>window.model = " + ra

        def headers = attrsMap.headers
        def properties = attrsMap.properties
        def rows = attrsMap.rows
        def altRowColor = attrsMap.altRowColor

        out << "<table style=\"-fs-table-paginate: paginate;\">" << LF
        out << "<thead><tr>" << LF
        headers.each { header ->
            out << "<th>$header</th>" << LF
        }
        out << "</tr></thead><tbody>" << LF

        rows.eachWithIndex { row, rowIdx ->
            if(altRowColor && rowIdx % 2) {
                out << "<tr style='background-color:${altRowColor}'>" << LF
            } else {
                out << "<tr>" << LF
            }
            properties.each { property ->
                def value
                if(property instanceof Closure) {
                    value = property(row)
                } else {
                    value = getProperty(row, property as String)

                }
                out << "<td>${value}</td>" << LF
            }

            out << "</tr>" << LF
        }
        out << "</tbody></table>" << LF
    }
}
