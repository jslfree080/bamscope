package com.jslfree080.process;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u00ad\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u0005\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0\u00070\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0003\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0018\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00070\u0006\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\b\u0012\u0006\u0010\u0012\u001a\u00020\b\u00a2\u0006\u0002\u0010\u0013J\u0006\u0010\u001c\u001a\u00020\u001dR\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00030\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u00060\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/jslfree080/process/PlotAlignment;", "", "newPositions", "", "", "newSamtoolsMap", "", "Lkotlin/Pair;", "", "yCoordinates", "bases", "pseudoReferenceForLegend", "basesRef", "qualities", "pairForShift", "chr", "intPos", "startPos", "endPos", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "alpha", "", "baseColors", "", "data", "dataRef", "legendInterestIndices", "shiftPositionOfInterest", "letsPlot", "", "bamscope"})
public final class PlotAlignment {
    private final java.util.List<java.lang.Integer> newPositions = null;
    private final java.util.List<java.lang.Integer> yCoordinates = null;
    private final java.util.List<java.lang.String> bases = null;
    private final java.util.List<java.lang.String> pseudoReferenceForLegend = null;
    private final java.util.List<java.lang.String> basesRef = null;
    private final java.util.List<java.lang.Integer> qualities = null;
    private final java.util.List<kotlin.Pair<java.lang.Integer, java.lang.Integer>> pairForShift = null;
    private final java.lang.String chr = null;
    private final java.lang.String intPos = null;
    private final java.lang.String startPos = null;
    private final java.lang.String endPos = null;
    private final java.util.List<java.lang.Double> alpha = null;
    private final java.util.Map<java.lang.String, java.util.List<? extends java.lang.Object>> data = null;
    private final java.util.Map<java.lang.String, java.util.List<java.lang.Object>> dataRef = null;
    private final int shiftPositionOfInterest = 0;
    private final java.util.List<java.lang.Integer> legendInterestIndices = null;
    private java.util.Map<java.lang.String, java.lang.String> baseColors;
    
    public PlotAlignment(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> newPositions, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.Integer, java.lang.String>> newSamtoolsMap, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> yCoordinates, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> bases, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> pseudoReferenceForLegend, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> basesRef, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> qualities, @org.jetbrains.annotations.NotNull()
    java.util.List<kotlin.Pair<java.lang.Integer, java.lang.Integer>> pairForShift, @org.jetbrains.annotations.NotNull()
    java.lang.String chr, @org.jetbrains.annotations.NotNull()
    java.lang.String intPos, @org.jetbrains.annotations.NotNull()
    java.lang.String startPos, @org.jetbrains.annotations.NotNull()
    java.lang.String endPos) {
        super();
    }
    
    public final void letsPlot() {
    }
}