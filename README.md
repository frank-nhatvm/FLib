

## Step 1: 
- create a folder named 'public'
- checkout fpublic repository: git clone git@github.com:frank-nhatvm/fpublic.git 

## public
- Execute :
```bash 
./gradlew :flib:assembleRelease 
```

- publish:
```bash 
./gradlew :flib:publishFlibPublicationToFPublicReleasesRepository 
```