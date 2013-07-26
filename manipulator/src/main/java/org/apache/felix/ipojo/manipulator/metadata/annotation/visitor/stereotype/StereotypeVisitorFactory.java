/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.felix.ipojo.manipulator.metadata.annotation.visitor.stereotype;

import org.apache.felix.ipojo.manipulator.metadata.annotation.model.AnnotationType;
import org.apache.felix.ipojo.manipulator.spi.AnnotationVisitorFactory;
import org.apache.felix.ipojo.manipulator.spi.BindingContext;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.MethodNode;

/**
* User: guillaume
* Date: 11/07/13
* Time: 14:26
*/
public class StereotypeVisitorFactory implements AnnotationVisitorFactory {
    private final AnnotationType m_annotationType;

    public StereotypeVisitorFactory(final AnnotationType annotationType) {
        m_annotationType = annotationType;
    }

    public AnnotationVisitor newAnnotationVisitor(BindingContext context) {
        if (context.getNode() instanceof ClassNode) {
            return new TypeStereotypeVisitor((ClassVisitor) context.getVisitor(),
                                             m_annotationType);
        } else if (context.getNode() instanceof FieldNode) {
            return new FieldStereotypeVisitor((FieldVisitor) context.getVisitor(),
                                              m_annotationType);

        } else if ((context.getNode() instanceof MethodNode) &&
                (context.getParameterIndex() == BindingContext.NO_INDEX)) {
            return new MethodStereotypeVisitor((MethodVisitor) context.getVisitor(),
                                               m_annotationType);

        } else {
            // last case: method parameter annotation
            return new ParameterStereotypeVisitor((MethodVisitor) context.getVisitor(),
                                                  context.getParameterIndex(),
                                                  m_annotationType);
        }

    }

    @Override
    public String toString() {
        return "StereotypeVisitorFactory";
    }
}
