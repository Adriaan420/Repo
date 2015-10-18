package com.company;

class SAXHandler extends DefaultHandler {

    Measurement[] measurementList = new Measurement[10];
    Measurement mes = null;
    String content = null;
    int count = 0;
    @Override
    //Triggered when the start of tag is found.
    public void startElement(String uri, String localName,
                             String qName, Attributes attributes)
            throws SAXException {

        switch(qName){
            //Create a new Employee object when the start tag is found
            case "WEATHERDATA":
                this.count = 0;
                break;
            case "MEASUREMENT":
                mes = new Measurement();
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName,
                           String qName) throws SAXException {
        switch(qName){
            //Add the employee to list once end tag is found
            case "MEASUREMENT":
                this.measurementList[this.count] = this.mes;
                this.count++;
                //System.out.println(this.mes.toString());
                break;
            case "WEATHERDATA":
                //System.out.println("--------------------------------");
                throw new SAXInteruptException("done",measurementList);
                //For all other end tags the employee has to be updated.
            case "STN":
                mes.stn = content;
                break;
            case "DATE":
                mes.date = content;
                break;
            case "TIME":
                mes.time = content;
                break;
            case "TEMP":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.temp = Float.valueOf(content);
                }
                break;
            case "DEWP":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.dewp = Float.valueOf(content);
                }
                break;
            case "STP":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.stp = Float.valueOf(content);
                }
                break;
            case "SLP":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.slp = Float.valueOf(content);
                }
                break;
            case "VISIB":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.visib = Float.valueOf(content);
                }
                break;
            case "WDSP":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.wdsp = Float.valueOf(content);
                }
                break;
            case "PRCP":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.prcp = Float.valueOf(content);
                }
                break;
            case "SNDP":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.sndp = Float.valueOf(content);
                }
                break;
            case "FRSHTT":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.frshtt = Float.valueOf(content);
                }
                break;
            case "CLDC":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else{
                    mes.cldc = Float.valueOf(content);
                }
                break;
            case "WNDDIR":
                if(content.isEmpty()) {
                    mes.temp = null;
                }else {
                    mes.wnddir = Float.valueOf(content);
                }
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        content = String.copyValueOf(ch, start, length).trim();
    }

}