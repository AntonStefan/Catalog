package com.pachete;

public interface Visitor {
    void visit(Assistant assistant);
    void visit(Teacher teacher);
}
