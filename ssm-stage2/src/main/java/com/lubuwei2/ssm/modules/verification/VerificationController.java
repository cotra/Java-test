package com.lubuwei2.ssm.modules.verification;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lubuwei2.ssm.api.PathConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@RestController
@RequestMapping(value = PathConfig.API_VERIFICATION)
public class VerificationController {

    @Autowired
    DefaultKaptcha defaultKaptcha;

    // 获取验证码
    @GetMapping(value = "kaptcha", produces = MediaType.IMAGE_JPEG_VALUE)
    public void getKaptcha(@RequestParam(value = "flag") String flag, HttpServletResponse response, HttpSession session) {
        // 获得验证码文本和图片
        String kaptcha = defaultKaptcha.createText();
        BufferedImage kaptchaImage = defaultKaptcha.createImage(kaptcha);
        // 保存在session
        session.setAttribute(flag, kaptcha);
        // 返回
        OutputStream out = null;
        try {
            ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
            // 写入图片
            ImageIO.write(kaptchaImage, "jpeg", jpegOutputStream);
            byte[] captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
            // 设置响应头
            VerificationLogic.setHeaders(response);
            // 写入
            out = response.getOutputStream();
            out.write(captchaChallengeAsJpeg);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.flush();
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
