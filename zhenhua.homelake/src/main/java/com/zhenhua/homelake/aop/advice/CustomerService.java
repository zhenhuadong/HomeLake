package com.zhenhua.homelake.aop.advice;

public class CustomerService implements Service {

	private String name;
	private String url;
	
	public CustomerService(String name, String url) {
		this.name=name;
		this.url=url;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public void execute() {
		System.out.println(format("%s [%s, %s]", this.getClass().getName(), this.name, this.url));
	}
	
    /**
     * Substitutes each {@code %s} in {@code template} with an argument. These are matched by
     * position: the first {@code %s} gets {@code args[0]}, etc.  If there are more arguments than
     * placeholders, the unmatched arguments will be appended to the end of the formatted message in
     * square braces.
     *
     * @param template a non-null string containing 0 or more {@code %s} placeholders.
     * @param args the arguments to be substituted into the message template. Arguments are converted
     *     to strings using {@link String#valueOf(Object)}. Arguments can be null.
     */
    // Note that this is somewhat-improperly used from Verify.java as well.
    static String format(String template, Object... args) {
      template = String.valueOf(template); // null -> "null"

      // start substituting the arguments into the '%s' placeholders
      StringBuilder builder = new StringBuilder(template.length() + 16 * args.length);
      int templateStart = 0;
      int i = 0;
      while (i < args.length) {
        int placeholderStart = template.indexOf("%s", templateStart);
        if (placeholderStart == -1) {
          break;
        }
        builder.append(template.substring(templateStart, placeholderStart));
        builder.append(args[i++]);
        templateStart = placeholderStart + 2;
      }
      builder.append(template.substring(templateStart));

      // if we run out of placeholders, append the extra args in square braces
      if (i < args.length) {
        builder.append(" [");
        builder.append(args[i++]);
        while (i < args.length) {
          builder.append(", ");
          builder.append(args[i++]);
        }
        builder.append(']');
      }

      return builder.toString();
    }


}
