package com.lubuwei2.ssm.modules.verification;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lubuwei2.ssm.api.PathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

@RestController
@RequestMapping(value = PathConfig.API_VERIFICATION)
public class VerificationController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    @GetMapping(value = "kaptcha", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getKaptcha(HttpServletResponse response) throws Exception {
        OutputStream out = null;
        try {
            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
            String createText = defaultKaptcha.createText();
            BufferedImage bufferedImage = defaultKaptcha.createImage(createText);
            ImageIO.write(bufferedImage, "jpeg", jpegOutputStream);
            byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
            VerificationLogic.setHeaders(response);
            out = response.getOutputStream();

            out.write(captchaChallengeAsJpeg);
            out.flush();
            out.close();

        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        } finally {
            if (out != null) {
                out.flush();
                out.close();
            }
        }
    }
}
