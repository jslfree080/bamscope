package com.jslfree080.process.cigars;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f\u00a2\u0006\u0002\u0010\rJ\u0006\u0010&\u001a\u00020\'J\u0006\u0010(\u001a\u00020\'J\u0006\u0010)\u001a\u00020\'J\u0006\u0010*\u001a\u00020\'J\u0006\u0010+\u001a\u00020\'J\u0006\u0010,\u001a\u00020\'J\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00070\fJ\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0007J\u0006\u00100\u001a\u00020\u0007R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\b\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0010\"\u0004\b#\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0010\"\u0004\b%\u0010\u0012\u00a8\u00061"}, d2 = {"Lcom/jslfree080/process/cigars/CigarInsertion;", "", "sb", "Ljava/lang/StringBuilder;", "parameterMID", "Lcom/jslfree080/process/cigars/ParameterMID;", "seqPos", "", "refPos", "qual", "", "insertedIndexes", "", "(Ljava/lang/StringBuilder;Lcom/jslfree080/process/cigars/ParameterMID;IILjava/lang/String;Ljava/util/List;)V", "count", "getCount", "()I", "setCount", "(I)V", "getInsertedIndexes", "()Ljava/util/List;", "setInsertedIndexes", "(Ljava/util/List;)V", "getParameterMID", "()Lcom/jslfree080/process/cigars/ParameterMID;", "setParameterMID", "(Lcom/jslfree080/process/cigars/ParameterMID;)V", "partialIncrement", "getPartialIncrement", "setPartialIncrement", "getQual", "()Ljava/lang/String;", "setQual", "(Ljava/lang/String;)V", "getRefPos", "setRefPos", "getSeqPos", "setSeqPos", "basesAppend", "", "blockNumbersAppend", "commonAppend", "partialIncrementsWithZeroAppend", "pseudoReferenceForLegendAppend", "qualitiesAppend", "returnInsertedIndexes", "returnShiftedParameterMID", "returnShiftedRefPos", "returnShiftedSeqPos", "bamscope"})
public final class CigarInsertion {
    private final java.lang.StringBuilder sb = null;
    @org.jetbrains.annotations.NotNull()
    private com.jslfree080.process.cigars.ParameterMID parameterMID;
    private int seqPos;
    private int refPos;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String qual;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> insertedIndexes;
    private int count = 0;
    private int partialIncrement = 0;
    
    public CigarInsertion(@org.jetbrains.annotations.NotNull()
    java.lang.StringBuilder sb, @org.jetbrains.annotations.NotNull()
    com.jslfree080.process.cigars.ParameterMID parameterMID, int seqPos, int refPos, @org.jetbrains.annotations.NotNull()
    java.lang.String qual, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> insertedIndexes) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jslfree080.process.cigars.ParameterMID getParameterMID() {
        return null;
    }
    
    public final void setParameterMID(@org.jetbrains.annotations.NotNull()
    com.jslfree080.process.cigars.ParameterMID p0) {
    }
    
    public final int getSeqPos() {
        return 0;
    }
    
    public final void setSeqPos(int p0) {
    }
    
    public final int getRefPos() {
        return 0;
    }
    
    public final void setRefPos(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQual() {
        return null;
    }
    
    public final void setQual(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> getInsertedIndexes() {
        return null;
    }
    
    public final void setInsertedIndexes(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> p0) {
    }
    
    public final int getCount() {
        return 0;
    }
    
    public final void setCount(int p0) {
    }
    
    public final int getPartialIncrement() {
        return 0;
    }
    
    public final void setPartialIncrement(int p0) {
    }
    
    public final void commonAppend() {
    }
    
    public final void pseudoReferenceForLegendAppend() {
    }
    
    public final void basesAppend() {
    }
    
    public final void qualitiesAppend() {
    }
    
    public final void blockNumbersAppend() {
    }
    
    public final void partialIncrementsWithZeroAppend() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.jslfree080.process.cigars.ParameterMID returnShiftedParameterMID() {
        return null;
    }
    
    public final int returnShiftedSeqPos() {
        return 0;
    }
    
    public final int returnShiftedRefPos() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> returnInsertedIndexes() {
        return null;
    }
}