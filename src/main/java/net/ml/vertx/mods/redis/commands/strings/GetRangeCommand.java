/*
 * Copyright 2011-2012 the original author or authors.
 *
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
 */
package net.ml.vertx.mods.redis.commands.strings;

import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.json.JsonObject;
import net.ml.vertx.mods.redis.CommandContext;
import net.ml.vertx.mods.redis.commands.Command;
import net.ml.vertx.mods.redis.commands.CommandException;

import redis.clients.jedis.exceptions.JedisException;

/**
 * GetRangeCommand
 * <p>
 * 
 * @author <a href="http://marx-labs.de">Thorsten Marx</a>
 */
public class GetRangeCommand extends Command {
	
	public static final String COMMAND = "getrange";

	public GetRangeCommand () {
		super(COMMAND);
	}
	
	@Override
	public void handle(Message<JsonObject> message, CommandContext context) throws CommandException {
		String key = getMandatoryString("key", message);
		checkNull(key, "key can not be null");		

		Number start = message.body.getNumber("start");
		checkNull(start, "start can not be null");
		checkType(start, "start must be an integer or long", new Class<?> []{Integer.class, Long.class});
		
		
		Number end = message.body.getNumber("end");
		checkNull(end, "end can not be null");
		checkType(end, "end must be an integer or long", new Class<?> []{Integer.class, Long.class});
		
		try {
			String value = context.getClient().getrange(key, start.longValue(), end.longValue());
			
			response(message, value);
		} catch (JedisException e) {
			sendError(message, e.getLocalizedMessage());
		}

	}
}