package peripurnama.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

public class CustomHandlerExceptionResolver extends DefaultHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		try {

			if (ex instanceof java.lang.Throwable) {

				return new ModelAndView("redirect:/uncaughtException");
			} else if (ex instanceof java.lang.Exception) {

				return new ModelAndView("redirect:/uncaughtException");
			} else if (response.getStatus() == 404) {

				return new ModelAndView("redirect:/resourceNotFound");
			} else if (response.getStatus() == 500) {

				return new ModelAndView("redirect:/resourceNotFound");
			} // end webflow
			// error 500
			else if (ex instanceof org.springframework.context.ApplicationContextException) {
				logger.warn("applicationcontextexception");
				return new ModelAndView("redirect:/resourceNotFound");
			}
			// end error 500

			// default
			return super.doResolveException(request, response, handler, ex);
		} catch (Exception handlerException) {
			logger.warn("Handling of [" + ex.getClass().getName() + "] resulted in Exception", handlerException);
		}
		return null;
	}

}