package com.mickaelg.cleanarchitecture.domain.executor;

import com.mickaelg.cleanarchitecture.domain.interactors.UseCase;

import java.util.concurrent.Executor;

/**
 * Executor implementation can be based on different frameworks or techniques of asynchronous
 * execution, but every implementation will execute the
 * {@link UseCase} out of the UI thread.
 */
public interface IThreadExecutor extends Executor {}
