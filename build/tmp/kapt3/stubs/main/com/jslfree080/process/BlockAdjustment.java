package com.jslfree080.process;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/jslfree080/process/BlockAdjustment;", "", "positions", "", "", "blockNumbers", "partialIncrementsWithZero", "insertedIndexes", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "inBlock", "", "insertedPositions", "", "insertedPositionsStart", "newPositions", "outputForGap", "partialIncrements", "posIndex", "shiftCount", "generateOutputForGap", "", "bamscope"})
public final class BlockAdjustment {
    private final java.util.List<java.lang.Integer> positions = null;
    private final java.util.List<java.lang.Integer> blockNumbers = null;
    private final java.util.List<java.lang.Integer> partialIncrementsWithZero = null;
    private final java.util.List<java.lang.Integer> insertedPositions = null;
    private final java.util.List<java.lang.Integer> partialIncrements = null;
    private final java.util.List<java.lang.Integer> insertedPositionsStart = null;
    private final java.util.List<java.lang.Integer> newPositions = null;
    private final java.util.List<java.lang.Integer> outputForGap = null;
    private int posIndex = 0;
    private boolean inBlock = false;
    private int shiftCount = 0;
    
    public BlockAdjustment(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> positions, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> blockNumbers, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> partialIncrementsWithZero, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> insertedIndexes) {
        super();
    }
    
    public final void generateOutputForGap() {
    }
}