package uk.ac.ebi.pride.archive.repo.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * {@code PasswordUtilities} is a utility class which handles password related functions
 *
 * <p>To encode password, it use an instance of {@code BCryptPasswordEncoder}, which offers strong
 * hashing
 *
 * <p>To generate password, it use an instance of {@code RandomStringUtils} from Apache commons
 *
 * @author Rui Wang
 * @version $Id$
 * @see PasswordEncoder, BCryptPasswordEncoder, RandomStringUtils
 */
public final class PasswordUtilities {

  /** default password encoder */
  private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

  /** default password length */
  private static final int PASSWORD_LENGTH = 12;

  private PasswordUtilities() {}

  public static String encode(String passwordPlainText) {
    return encoder.encode(passwordPlainText);
  }

  public static boolean matches(String passwordPlainText, String passwordEncoded) {
    return encoder.matches(passwordPlainText, passwordEncoded);
  }

  public static String generatePassword() {
    return RandomStringUtils.randomAlphanumeric(PASSWORD_LENGTH);
  }

  public static String generateEncodedPassword() {
    return encode(generatePassword());
  }
}
