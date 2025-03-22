package site.easy.to.build.crm.DataConfig.parameter;

import site.easy.to.build.crm.DataConfig.LineValue;

@FunctionalInterface
public interface SetterCSV<T> {
    public T get(LineValue value);
}
