#!/bin/bash

echo "================================"
echo "   DSA Git Auto Push"
echo "================================"

echo ""
echo "→ Staging changes..."
git add .

if git diff --cached --quiet; then
    echo ""
    echo "✓ No changes to commit."
    echo "✓ Repository is already up to date."
    exit 0
fi

echo ""
echo "→ Changes detected:"
git diff --cached --stat

echo ""
echo "→ Creating commit..."
git commit -m "Add DSA solution"

if [ $? -ne 0 ]; then
    echo ""
    echo "✗ Commit failed."
    exit 1
fi

echo ""
echo "→ Pushing to GitHub..."
git push

if [ $? -ne 0 ]; then
    echo ""
    echo "✗ Push failed."
    echo "  Your commit is still saved locally."
    exit 1
fi

echo ""
echo "================================"
echo "✓ Successfully pushed to GitHub"
echo "================================"