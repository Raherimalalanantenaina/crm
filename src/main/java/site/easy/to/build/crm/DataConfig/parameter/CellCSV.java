package site.easy.to.build.crm.DataConfig.parameter;

import site.easy.to.build.crm.DataConfig.exception.CSVException;

public interface CellCSV<T> {
    public T getValue(String value,int line)throws CSVException;
}
