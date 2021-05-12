package com.hthj.utils;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

/**
 * @Description
 * @Author pengx
 * @Date 2020/4/17 12:47
 */
final public class RangeScope {
    private Map<String, RangeUnit> scope = new HashMap<>();

    public boolean hasElement() {
        return scope.keySet().size() > 0;
    }

    public Iterator<String> iterator() {
        return scope.keySet().iterator();
    }

    public void putStart(String fieldName, Object fieldValue) {
        if (!scope.keySet().contains(fieldName)) {
            scope.put(fieldName, new RangeUnit());
        }
        scope.get(fieldName).setStart(fieldValue);
    }

    public void putEnd(String fieldName, Object fieldValue) {
        if (!scope.keySet().contains(fieldName)) {
            scope.put(fieldName, new RangeUnit());
        }
        scope.get(fieldName).setEnd(fieldValue);
    }

    public Object getStart(String fieldName) {
        return Optional.ofNullable(scope.get(fieldName)).map(RangeUnit::getStart).orElse(null);
    }

    public Object getEnd(String fieldName) {
        return Optional.ofNullable(scope.get(fieldName)).map(RangeUnit::getEnd).orElse(null);
    }

    private class RangeUnit {
        private Object start;
        private Object end;

        public Object getStart() {
            return start;
        }

        public void setStart(Object start) {
            this.start = start;
        }

        public Object getEnd() {
            return end;
        }

        public void setEnd(Object end) {
            this.end = end;
        }
    }


    public Map<String, RangeUnit> getScope() {
        return scope;
    }

    public void setScope(Map<String, RangeUnit> scope) {
        this.scope = scope;
    }
}
