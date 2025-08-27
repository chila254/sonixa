# YouTube API Keystore Setup for Sonixa Music

## Generated Keystores

### Debug Keystore
- **File**: `debug.keystore`
- **Alias**: `androiddebugkey`
- **Password**: `android`
- **SHA-1 Fingerprint**: `85:0D:C2:45:EE:42:66:C9:F2:59:AA:3A:C6:3D:13:E5:07:86:4B:53`

### Release Keystore
- **File**: `sonixa-release.keystore`
- **Alias**: `sonixa-key`
- **Password**: `sonixa123`
- **SHA-1 Fingerprint**: `42:9F:42:4A:29:49:45:8A:EB:40:CC:63:FF:5A:7C:EF:4F:6B:2C:BC`

## Setting Up YouTube API

### Step 1: Google Cloud Console Setup
1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Create a new project or select existing one
3. Enable **YouTube Data API v3**

### Step 2: Create OAuth 2.0 Credentials
1. Go to **Credentials** section
2. Click **Create Credentials** → **OAuth 2.0 Client ID**
3. Select **Android** application type
4. Add both SHA-1 fingerprints:
   - Debug: `85:0D:C2:45:EE:42:66:C9:F2:59:AA:3A:C6:3D:13:E5:07:86:4B:53`
   - Release: `42:9F:42:4A:29:49:45:8A:EB:40:CC:63:FF:5A:7C:EF:4F:6B:2C:BC`
5. Add your package name: `com.sonixa.music`

### Step 3: Configure Gradle for Signing
Add the following to your `app/build.gradle.kts`:

```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("../sonixa-release.keystore")
            storePassword = "sonixa123"
            keyAlias = "sonixa-key"
            keyPassword = "sonixa123"
        }
        getByName("debug") {
            storeFile = file("../debug.keystore")
            storePassword = "android"
            keyAlias = "androiddebugkey"
            keyPassword = "android"
        }
    }

    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            // ... other release config
        }
        debug {
            signingConfig = signingConfigs.getByName("debug")
            // ... other debug config
        }
    }
}
```

### Step 4: Add YouTube API Configuration
In your app, you'll need to configure the YouTube API client. Based on your code, it seems to use `com.sonixa.innertube.YouTube` which likely handles authentication.

### Important Notes
1. **Keep keystores secure** - Never commit them to version control
2. **Add to .gitignore**:
   ```
   *.keystore
   *.jks
   ```
3. **Backup release keystore** - You'll need it for app updates
4. The debug keystore is for development/testing only

## Testing YouTube Login
After setting up the API credentials, you should be able to:
1. Build and run the app in debug mode
2. Test YouTube account login functionality
3. Verify the SHA-1 fingerprint matches what you registered

## Troubleshooting
If YouTube login fails:
1. Verify SHA-1 fingerprints match exactly
2. Check package name in Google Cloud Console
3. Ensure YouTube Data API v3 is enabled
4. Check internet connectivity and API quotas
