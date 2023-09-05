package minori.eden.sion.asmlib

import org.objectweb.asm.MethodVisitor
import org.objectweb.asm.Opcodes

/**
 * @author Sion
 * @date 2023/9/4 17:29
 * @description
 * @version 1.0.0
 **/
class LifecycleOnCreateMethodVisitor(mv: MethodVisitor) : MethodVisitor(Opcodes.ASM9 , mv) {

    override fun visitCode() {
        super.visitCode()
        mv.visitLdcInsn("TAG")
        mv.visitTypeInsn(Opcodes.NEW, "java/lang/StringBuilder")
        mv.visitInsn(Opcodes.DUP)
        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/StringBuilder", "<init>", "()V", false)
        mv.visitLdcInsn("-------> onCreate : ")
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
        mv.visitVarInsn(Opcodes.ALOAD, 0)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Object", "getClass", "()Ljava/lang/Class;", false)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/Class", "getSimpleName", "()Ljava/lang/String;", false)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "append", "(Ljava/lang/String;)Ljava/lang/StringBuilder;", false)
        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "java/lang/StringBuilder", "toString", "()Ljava/lang/String;", false)
        mv.visitMethodInsn(Opcodes.INVOKESTATIC, "android/util/Log", "i", "(Ljava/lang/String;Ljava/lang/String;)I", false)
        mv.visitInsn(Opcodes.POP)
    }

    override fun visitInsn(opcode: Int) {
        super.visitInsn(opcode)
    }
}