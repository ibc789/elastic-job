/*
 * Copyright 1999-2015 dangdang.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * </p>
 */

package com.dangdang.ddframe.job.exception;

/**
 * 分布式作业抛出的异常基类.
 * 
 * @author zhangliang
 */
public class JobException extends RuntimeException {
    
    private static final long serialVersionUID = -5323792555332165319L;
    
    public JobException(final String errorMessage, final Object... args) {
        super(String.format(errorMessage, args));
    }
    
    public JobException(final Throwable cause) {
        super(cause);
    }
}
