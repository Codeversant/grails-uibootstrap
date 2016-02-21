package grails.uibootstrap


class DateTimeFieldTagLib {
    static defaultEncodeAs = [taglib: 'none']
    static namespace = "boots"

    def generateTemplate(String fieldName, String modelName,String minTime, String maxTime, String minDate, Boolean required,String defaultTime) {
//propagate required attribute from tag markup to tag generated markup
        def requiredString = ""
        if(required) {
            requiredString = 'required="required"'
        }
        def tmpl = """
<div ng-controller="DateTimeCtrl as dateTimeCtrl" ng-init="dateTimeCtrl.dateTimeValue=${modelName};dateTimeCtrl.defaultTime=\'${defaultTime}\'">
    <div class="row">
        <div class="col-md-7">
            <div class="input-group">
                <input type="text" class="form-control" uib-datepicker-popup="MM/dd/yyyy" ng-model="dateTimeCtrl.dateValue" id="${fieldName}"
                       is-open="${fieldName}Opened" datepicker-options="dateOptions" min-date="${minDate}" show-weeks="false" show-button-bar="false" ${requiredString}/>
                <span class="input-group-btn">
                    <button type="button" class="btn btn-default" ng-click="${fieldName}Opened=!${fieldName}Opened"><i class="glyphicon glyphicon-calendar"></i></button>
                </span>
            </div>
        </div>
        <div class="col-md-5">
            <input type="text" class="form-control" dn-timepicker="h:mm a" min-time="${minTime}" max-time="${maxTime}" step="15" ng-model="dateTimeCtrl.timeValue" ${requiredString}/>
        </div>
    </div>
    <input type="hidden" ng-value="(dateTimeCtrl.dateTimeValue | date: 'yyyy-MM-dd HH:mm:ss')" name="${fieldName}"/>
</div>
"""
        return tmpl        
    }
    
    def dateTimeField = { attrs, body ->
        String fieldName = attrs.name
        String modelName = attrs.modelName
        String minTime = attrs.minTime
        String maxTime = attrs.maxTime
        String minDate = attrs.minDate
        String defaultTime = attrs.defaultTime

        boolean required = !!attrs.required
        if(!minTime) {
            minTime = "12:00 AM"
        }
        if(!maxTime) {
            maxTime = "11:59 PM"
        }
        if(!defaultTime) {
            defaultTime = ""
        }
        if(!minDate) {
            minDate = '01/01/1970'
        }
        out << "" + raw((generateTemplate(fieldName,modelName,minTime,maxTime,minDate,required, defaultTime)) as String) + ""

    }

    def generateDatepickerTemplate(String fieldName, String value, String modelName, String minDateVariable, Boolean required) {
        //propagate required attribute from tag markup to tag generated markup
        def requiredString = ""
        if(required) {
            requiredString = 'required="required"'
        }

        def tmpl = """
<div class="input-group">
    <input type="text" class="form-control" name="${fieldName}" uib-datepicker-popup="MM/dd/yyyy" ng-model="${modelName}"
             is-open="${fieldName}Opened" show-weeks="false" min-date="${minDateVariable}"
             value="${value}" show-button-bar="false" ng-value="${modelName}" ${requiredString}/>
    <span class="input-group-btn">
        <button type="button" class="btn btn-default" ng-click="${fieldName}Opened=!${fieldName}Opened"><i class="glyphicon glyphicon-calendar"></i></button>
    </span>
</div>
"""
        return tmpl
    }
    def dateField = { attrs, body ->
        String name = attrs.name
        String value = attrs.value
        String modelName = attrs.modelName
        String minDateVariable = attrs.minDate
        if(!minDateVariable) {
            minDateVariable = '01/01/1970'
        }
        boolean required = !!attrs.required
        out << "" + raw((generateDatepickerTemplate(name, value,modelName,minDateVariable,required)) as String) + ""

    }
    def generateTimepickerTemplate(String fieldName, String value, String modelName,String minTime, String maxTime, Boolean required) {
//propagate required attribute from tag markup to tag generated markup
        def requiredString = ""
        if(required) {
            requiredString = 'required="required"'
        }
        def tmpl = """
            <input type="text" name="${fieldName}" class="form-control" dn-timepicker="h:mm a" min-time="${minTime}" max-time="${maxTime}" step="15" value="${value}" ng-model="${modelName}" ng-value="${modelName}" ${requiredString}/>
"""
        return tmpl
    }
    def timeField = { attrs, body ->
        String name = attrs.name
        String value = attrs.value
        String modelName = attrs.modelName
        String minTime = attrs.minTime
        String maxTime = attrs.maxTime
        boolean required = !!attrs.required
        if(!minTime) {
            minTime = "12:00 AM"
        }
        if(!maxTime) {
            maxTime = "11:59 PM"
        }
        out << "" + raw((generateTimepickerTemplate(name, value,modelName,minTime,maxTime, required)) as String) + ""
    }
}
