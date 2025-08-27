# YouTube API Configuration for Sonixa Music

## Configuration Steps Completed:

### 1. Keystore Setup ✅
- Debug keystore created with SHA-1: `85:0D:C2:45:EE:42:66:C9:F2:59:AA:3A:C6:3D:13:E5:07:86:4B:53`
- Release keystore created with SHA-1: `42:9F:42:4A:29:49:45:8A:EB:40:CC:63:FF:5A:7C:EF:4F:6B:2C:BC`
- Gradle signing configurations updated

### 2. Google Services Plugin ✅
- Added to project-level `build.gradle.kts`
- Added to app-level `build.gradle.kts`

### 3. Configuration File ✅
- Created `app/google-services.json` template

## Next Steps:

### 1. Update Google Cloud Console
1. Go to your Google Cloud Console project
2. Navigate to **APIs & Services** > **Credentials**
3. For your OAuth 2.0 Client ID, add both SHA-1 fingerprints:
   - Debug: `85:0D:C2:45:EE:42:66:C9:F2:59:AA:3A:C6:3D:13:E5:07:86:4B:53`
   - Release: `42:9F:42:4A:29:49:45:8A:EB:40:CC:63:FF:5A:7C:EF:4F:6B:2C:BC`
4. Package name: `com.sonixa.music`

### 2. Configure google-services.json
Replace the placeholder values in `app/google-services.json` with your actual values from Google Cloud Console:

```json
{
  "project_info": {
    "project_number": "YOUR_ACTUAL_PROJECT_NUMBER",
    "project_id": "YOUR_ACTUAL_PROJECT_ID",
    "storage_bucket": "YOUR_ACTUAL_STORAGE_BUCKET"
  },
  "client": [
    {
      "client_info": {
        "mobilesdk_app_id": "YOUR_ACTUAL_MOBILE_SDK_APP_ID",
        "android_client_info": {
          "package_name": "com.sonixa.music"
        }
      },
      "oauth_client": [
        {
          "client_id": "YOUR_ACTUAL_OAUTH_CLIENT_ID",
          "client_type": 1,
          "android_info": {
            "package_name": "com.sonixa.music",
            "certificate_hash": "YOUR_ACTUAL_SHA1_FINGERPRINT"
          }
        }
      ],
      "api_key": [
        {
          "current_key": "YOUR_ACTUAL_API_KEY"
        }
      ]
    }
  ],
  "configuration_version": "1"
}
```

### 3. Environment Variables (Optional)
For production, you might want to use environment variables instead of hardcoding values. You can set these in your system or CI/CD pipeline:

```bash
# For release builds
export STORE_PASSWORD="sonixa123"
export KEY_ALIAS="sonixa-key"
export KEY_PASSWORD="sonixa123"

# For API keys (if not using google-services.json)
export YOUTUBE_API_KEY="your_api_key_here"
```

### 4. Build and Test
1. Sync Gradle files
2. Build the application
3. Test YouTube login functionality

### 5. Verify YouTube API Integration
Based on your existing code, the app uses `com.sonixa.innertube.YouTube` which should handle authentication. The configuration should enable:

- YouTube account login
- Access to YouTube Music API
- OAuth 2.0 authentication flow

### Troubleshooting:
- If authentication fails, verify SHA-1 fingerprints match exactly
- Check that YouTube Data API v3 is enabled in Google Cloud Console
- Ensure the package name matches exactly in all configurations
- Verify internet connectivity and API quotas

## Security Notes:
- Never commit actual API keys or client secrets to version control
- Use environment variables for production secrets
- Keep keystore passwords secure
- Regularly rotate API keys and OAuth credentials
