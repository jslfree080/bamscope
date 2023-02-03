package com.jslfree080.process;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010$\u001a\u00020%R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u0005R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u0005R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\t\"\u0004\b\u0012\u0010\u0005R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u0005R \u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\t\"\u0004\b\u0019\u0010\u0005R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\t\"\u0004\b\u001c\u0010\u0005R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u0005R\u000e\u0010 \u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u0005\u00a8\u0006&"}, d2 = {"Lcom/jslfree080/process/ParseRead;", "", "samtoolsViewLines", "", "", "(Ljava/util/List;)V", "bases", "", "getBases", "()Ljava/util/List;", "setBases", "blockNumbers", "", "getBlockNumbers", "setBlockNumbers", "directions", "insertedIndexes", "getInsertedIndexes", "setInsertedIndexes", "nonEmptyLines", "partialIncrementsWithZero", "getPartialIncrementsWithZero", "setPartialIncrementsWithZero", "positions", "getPositions", "setPositions", "pseudoReferenceForLegend", "getPseudoReferenceForLegend", "setPseudoReferenceForLegend", "qualities", "getQualities", "setQualities", "yCoordinate", "yCoordinates", "getYCoordinates", "setYCoordinates", "appender", "", "bamscope"})
public final class ParseRead {
    private final java.util.List<java.lang.String> nonEmptyLines = null;
    private int yCoordinate = 0;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> yCoordinates;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> positions;
    private java.util.List<java.lang.String> directions;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> pseudoReferenceForLegend;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.String> bases;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> qualities;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> blockNumbers;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> partialIncrementsWithZero;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> insertedIndexes;
    
    public ParseRead(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> samtoolsViewLines) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getYCoordinates() {
        return null;
    }
    
    public final void setYCoordinates(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getPositions() {
        return null;
    }
    
    public final void setPositions(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getPseudoReferenceForLegend() {
        return null;
    }
    
    public final void setPseudoReferenceForLegend(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getBases() {
        return null;
    }
    
    public final void setBases(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getQualities() {
        return null;
    }
    
    public final void setQualities(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getBlockNumbers() {
        return null;
    }
    
    public final void setBlockNumbers(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getPartialIncrementsWithZero() {
        return null;
    }
    
    public final void setPartialIncrementsWithZero(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getInsertedIndexes() {
        return null;
    }
    
    public final void setInsertedIndexes(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    public final void appender() {
    }
}