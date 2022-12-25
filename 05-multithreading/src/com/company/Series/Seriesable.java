package com.company.Series;

import java.io.OutputStream;
import java.io.Writer;

public interface Seriesable {
    int MIN_LEN_OF_ARR = 1;
    int MAX_LEN_OF_ARR = 5;

    int MIN_NUM_OF_ELS_OF_SER = 1;
    int MAX_NUM_OF_ELS_OF_SER = 5;

    int MIN_NUM_OF_START_PAGES = 1;
    int MAX_NUM_OF_START_PAGES = 100;

    int MIN_NUM_OF_PAGES_OF_EL = 1;
    int MAX_NUM_OF_PAGES_OF_EL = 1000;

    int getNumOfEls();

    String getTitle();

    void setTitle(String title);

    int getNumOfStartPages();

    void setNumOfStartPages(int num);

    int getNumOfPagesOfEl(int index);

    int getSumOfPagesWithoutStart();

    void setNumOfPagesOfEl(int index, int num);

    void output(OutputStream out);

    void write(Writer out);
}
