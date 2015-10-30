package com.company;

public class Measurement {
        String stn;
        String date;
        String time;
        Float temp;
        Float dewp;
        Float stp;
        Float slp;
        Float visib;
        Float wdsp;
        Float prcp;
        Float sndp;
        Float frshtt;
        Float cldc;
        Float wnddir;

        @Override
        public String toString() {
            return stn+" | "+date+" | "+time+" | "+temp+" | "+dewp+" | "+stp+" | "+slp+" | "+visib+" | "+wdsp;
        }
    }
