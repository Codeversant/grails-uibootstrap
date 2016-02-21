package grails.uibootstrap

class BootstrapTagLib {
    static defaultEncodeAs = [taglib:'raw']
    static namespace = "boots"
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
    static LF = "\n"

    def panel = { Map attrsMap, body ->
        def title = attrsMap.title ?: ''
        def type = attrsMap.type ?: 'default'

        out << """"
<div class="panel panel-${type}">
    <div class="panel-heading">
        <h3 class="panel-title">${title}</h3>
    </div>
    <div class="panel-body">
        ${body()}
    </div>
    <div class="panel-footer">

    </div>
</div>
"""
    }
    def row = { Map attrsMap, body ->
       out << """
    <div class="row">
        ${body()}
    </div>
"""
    }
    def col6 = { Map attrsMap, body ->
        out << """
    <div class="col-md-6">
        ${body()}
    </div>
"""
    }
    def col3 = { Map attrsMap, body ->
        out << """
    <div class="col-md-3">
        ${body()}
    </div>
"""
    }
    def col4 = { Map attrsMap, body ->
        out << """
    <div class="col-md-4">
        ${body()}
    </div>
"""
    }
    def col12 = { Map attrsMap, body ->
        out << """
    <div class="col-md-12">
        ${body()}
    </div>
"""
    }
    def formGroup = { Map attrsMap, body ->
        def label = attrsMap.label = ''
        out << """
        <div class="form-group">
            <label class="control-label">${label}</label>
            ${body()}
        </div>
"""
    }

}
